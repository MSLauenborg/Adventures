public class Adventure {

    private Player player;
    private String correctAnswer;
    private EscaperoomMap map;

    public Adventure() {
        this.map = new EscaperoomMap();
        this.player = new Player(map.getStartRoom());
        this.correctAnswer = "white";
    }

    public boolean winningRoom5() {
        if (player.getCurrentRoom() == map.getWinningRoom()) {
            return true;
        }
        return false;
    }

    public String questionToWin() {
        return "What colour is snow? ";
    }

    public boolean checkAnswer(String playerAnswer) {
        if (correctAnswer.equals(playerAnswer)) {
            return true;
        }
        return false;
    }

    public void wrongAnswerMoveToStart() {
        this.player.moveTo(map.getStartRoom());
    }

    public boolean goNorth() {
        return this.player.goNorth();
    }

    public boolean goSouth() {
        return this.player.goSouth();
    }

    public boolean goEast() {
        return this.player.goEast();
    }

    public boolean goWest() {
        return this.player.goWest();
    }

    public Room getCurrentRoom() {
       return this.player.getCurrentRoom();
    }

    public void setPlayerName(String name) {
        this.player.setName(name);
    }

    public String getPlayerName() {
        return this.player.getName();
    }

}

