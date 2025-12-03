package controllers;

import models.level.Level;
import models.level.LevelManager;
import models.map.GameMap;
import models.map.MapLoader;
import models. player.ChefPlayer;
import models. core.Direction;

public class GameController {

    private Stage currentStage;
    private LevelManager levelManager;
    private boolean isPaused;

    public GameController() {
        this. levelManager = LevelManager.getInstance();
        this.isPaused = false;
    }

    public void startLevel(Level level) {
        levelManager.setCurrentLevel(level);

        GameMap map = MapLoader.loadPizzaMap();

        currentStage = new Stage(
                "stage_" + level. getId(),
                level.getMapType(),
                map
        );

        currentStage.applyLevelSettings(level);

        currentStage. initStage();
    }

    public void handleInput(char key) {
        if (currentStage == null || !currentStage. isGameRunning()) return;
        if (isPaused) return;

        ChefPlayer activeChef = currentStage.getActiveChef();
        if (activeChef == null || activeChef.isBusy()) return;

        GameMap map = currentStage.getGameMap();
        int currentX = activeChef.getPosition().getX();
        int currentY = activeChef.getPosition().getY();
        int newX = currentX;
        int newY = currentY;

        switch (Character.toUpperCase(key)) {
            case 'W', 38 -> {
                newY = currentY - 1;
                activeChef.setDirection(Direction.UP);
                if (canMoveTo(map, newX, newY)) {
                    activeChef.move(Direction.UP);
                }
            }
            case 'S', 40 -> {
                newY = currentY + 1;
                activeChef.setDirection(Direction.DOWN);
                if (canMoveTo(map, newX, newY)) {
                    activeChef. move(Direction.DOWN);
                }
            }
            case 'A', 37 -> {
                newX = currentX - 1;
                activeChef.setDirection(Direction.LEFT);
                if (canMoveTo(map, newX, newY)) {
                    activeChef.move(Direction.LEFT);
                }
            }
            case 'D', 39 -> {
                newX = currentX + 1;
                activeChef.setDirection(Direction.RIGHT);
                if (canMoveTo(map, newX, newY)) {
                    activeChef.move(Direction.RIGHT);
                }
            }
            case 'C', 67 -> handlePickupDrop();
            case 'V', 86 -> handleInteract();
            case 'Q', 81 -> currentStage.switchActiveChef();
        }
    }

    private boolean canMoveTo(GameMap map, int x, int y) {
        if (! map.isWalkable(x, y)) return false;

        for (ChefPlayer chef : currentStage.getChefs()) {
            if (chef != currentStage.getActiveChef() &&
                    chef.getPosition().getX() == x &&
                    chef.getPosition().getY() == y) {
                return false;
            }
        }
        return true;
    }

    private void handlePickupDrop() {
        ChefPlayer chef = currentStage. getActiveChef();
        GameMap map = currentStage.getGameMap();

        int frontX = chef. getPosition().getX();
        int frontY = chef.getPosition().getY();

        switch (chef.getDirection()) {
            case UP -> frontY--;
            case DOWN -> frontY++;
            case LEFT -> frontX--;
            case RIGHT -> frontX++;
        }

        var station = map.getStationAt(frontX, frontY);
        if (station != null) {
            chef.interact(station);
        }
    }

    private void handleInteract() {
        ChefPlayer chef = currentStage.getActiveChef();
        GameMap map = currentStage.getGameMap();

        int frontX = chef.getPosition(). getX();
        int frontY = chef.getPosition().getY();

        switch (chef. getDirection()) {
            case UP -> frontY--;
            case DOWN -> frontY++;
            case LEFT -> frontX--;
            case RIGHT -> frontX++;
        }

        var station = map.getStationAt(frontX, frontY);
        if (station != null) {
            chef.interact(station);
        }
    }

    public void togglePause() {
        isPaused = !isPaused;
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    public LevelManager getLevelManager() {
        return levelManager;
    }

    public boolean isPaused() {
        return isPaused;
    }
}