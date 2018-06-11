package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Components.RoundTracker;

import java.util.List;

public class GuiView extends View {

    private boolean singlePlayer;

    public GuiView(){

    }

    @Override
    public void startGUI(){
        String[] a = new String[]{""};
        GUI gui = new GUI();
        gui.main(a);

    }

    @Override
    public void setPlayerName(String username) {

    }

    @Override
    public void showID() {

    }

    @Override
    public void showGameStarted() {

    }

    @Override
    public void showNameChoose() {

    }

    @Override
    public void showName() {

    }

    @Override
    public void showNameOther(String name) {

    }

    @Override
    public void showNameError() {

    }

    @Override
    public void showPrivateCard(PrivateObjectiveCard privateObjectiveCard) {

    }

    @Override
    public void showPublicCard(List<PublicObjectiveCard> publicList) {

    }

    @Override
    public void showPatternList(List<PatternCard> patternCards) {

    }

    @Override
    public void showPatternChoose(int choose, List<PatternCard> patternCards) {

    }

    @Override
    public void showPattern(PatternCard patternCard) {

    }

    @Override
    public void showOtherPattern(PatternCard patternCard, String playerName) {

    }

    @Override
    public void showPatternUpdate(PatternCard patternCard) {

    }

    @Override
    public void showTokens(int tokensNumber) {

    }

    @Override
    public void showCurrentRound(int round) {

    }

    @Override
    public void showCurrentTurn() {

    }

    @Override
    public void showOtherCurrentTurn(String username) {

    }

    @Override
    public void showRollCommand() {

    }

    @Override
    public void showDraftPool(DraftPool draftPool) {

    }

    @Override
    public void showChooseCommand() {

    }

    @Override
    public void showMoveCommand(int poolSize) {

    }

    @Override
    public void showToolCommand(List<ToolCard> toolCards) {

    }

    @Override
    public void showRoundTracker(RoundTracker roundTracker) {

    }

    @Override
    public void showFinalRank(List<Player> playerList) {

    }

    @Override
    public void showWinner() {

    }

    @Override
    public void showLosers() {

    }

    @Override
    public void showTimer() {

    }

    @Override
    public void showOtherTimer(String playerName) {

    }

    @Override
    public void showToolCards(List<ToolCard> toolCardList) {

    }

    @Override
    public void showTokenError() {

    }

    @Override
    public void showGrozingRequest(int poolSize) {

    }

    @Override
    public void showEglomiseRequest() {

    }

    @Override
    public void showCopperFoilRequest() {

    }

    @Override
    public void showLathekinRequest() {

    }

    @Override
    public void showLensCutterRequest(int poolSize, List<Integer> round) {

    }

    @Override
    public void showFluxBrushRequest(int poolSize) {

    }

    @Override
    public void showGlazingHammerRequest() {

    }

    @Override
    public void showRunningPliersRequest(int poolSize) {

    }

    @Override
    public void showCorkBackedRequest(int poolSize) {

    }

    @Override
    public void showGrindingStoneRequest(int poolSize) {

    }

    @Override
    public void showFluxRemoverRequest(DiceColor color, int poolSize) {

    }

    @Override
    public void showTapWheelRequest() {

    }

    @Override
    public void showBoard(RoundTracker roundTracker, DraftPool draftPool) {

    }

    @Override
    public void showInvalidMove(String msg) {

    }

    @Override
    public void showSinglePlayerRequest() {

    }

    @Override
    public void showDifficultyRequest() {

    }

    @Override
    public void showPrivateSingle(List<PrivateObjectiveCard> publicList) {

    }

    @Override
    public void showToolSingleCommand(List<ToolCard> toolList, int poolSize) {

    }

    @Override
    public void showMatchError() {

    }

    @Override
    public void run() {

    }
}
