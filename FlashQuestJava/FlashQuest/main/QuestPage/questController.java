package QuestPage;

import AccountPage.AccountPage;
import Backend.Controller.FlashQuestController;
import Backend.Model.Flashcard;
import Backend.Model.Folder;
import CreateFolderPage.createFolderPage;
import FightPage.Battle;
import QuestPage.editQuest;
import FolderPage.folder;
import MenuPage.menu;
import javafx.stage.Stage;

public class questController {
    private final Stage stage;
    private final FlashQuestController flashQuestController;

    public questController(Stage stage, FlashQuestController flashQuestController) {
        this.stage = stage;
        this.flashQuestController = flashQuestController;
    }
    public void clickMenuButton() {
        menu Menu = new menu(stage, flashQuestController);
        Menu.show();
    }
    public void clickSmithFolderButton() {
        createFolderPage Smithfolder = new createFolderPage(stage, flashQuestController);
        Smithfolder.show();
    }
    public void clickQuestButton() {
        quest Quest = new quest(stage, flashQuestController);
        Quest.show();
    }
    public void clickUserButton() {
        // TODO HAGGAI
        AccountPage accountPage = new AccountPage(stage, flashQuestController);
        accountPage.show();
    }

    // TODO ADD BATTLE SCNECE LOGIC HERE
    public void clickStartButton(Folder folder) {
        if (!folder.isEmpty()) {
            Battle battlePage = new Battle();
            battlePage.setFlashQuestController(flashQuestController);
            battlePage.setFolder(folder);
            battlePage.start(stage);
            System.out.println("Please show");
        }
        else {
            System.out.println("Empty Folder");
        }
    }

    public void clickViewButton(Folder folder) {
        editQuest EditQuestPage = new editQuest(stage, flashQuestController, folder);
        EditQuestPage.show();
    }

    public void clickDeleteFolderBtn(Folder folder) {
        flashQuestController.deleteFolder(folder);
        quest QuestPage = new quest(stage, flashQuestController);
        QuestPage.show();
    }
}
