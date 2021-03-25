import java.util.List;
import java.util.Scanner;

public class CatalogUtilShell {
    /**
     * <p> Clasa abstracta CatalogShellComand retine date importante pentru rularea din command line a programului
     *     precum: numele comenzii, numarul parametrilor, lista acestora etc. </p>
     */
    private abstract static class CatalogShellCommand
    {
        protected CatalogUtil catalogUtil;
        protected CatalogUtilShell catalogUtilShell;
        protected String command;
        protected int parametersCount;

        public CatalogShellCommand(CatalogUtil catalogUtil, CatalogUtilShell catalogUtilShell, String command, int parametersCount) {
            this.catalogUtil = catalogUtil;
            this.catalogUtilShell = catalogUtilShell;
            this.command = command;
            this.parametersCount = parametersCount;
        }

        public CatalogUtil getCatalogUtil() {
            return catalogUtil;
        }

        public void setCatalogUtil(CatalogUtil catalogUtil) {
            this.catalogUtil = catalogUtil;
        }

        public CatalogUtilShell getCatalogUtilShell() {
            return catalogUtilShell;
        }

        public void setCatalogUtilShell(CatalogUtilShell catalogUtilShell) {
            this.catalogUtilShell = catalogUtilShell;
        }

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public int getParametersCount() {
            return parametersCount;
        }

        public void setParametersCount(int parametersCount) {
            this.parametersCount = parametersCount;
        }

        public abstract void behaviour(List<String> parameters) throws Exception;
    }
    // end of CatalogShellCommand class

    /**
     * <p> Clasa ExitCommand defineste comanda exit. </p>
     */
    protected static class ExitCommand extends CatalogShellCommand {
        public ExitCommand(CatalogUtilShell catalogUtilShell) {
            super(null, catalogUtilShell, "exit", 0);
        }

        @Override
        public void behaviour(List<String> parameters) throws Exception {
            this.catalogUtilShell.reinitialize();
        }
    }
    //end of ExitCommand class

    /**
     * <p> Clasa SaveCommand defineste cmanda save. </p>
     */
    private static class SaveCommand extends CatalogShellCommand {
        public SaveCommand(Catalog catalogUtil, CatalogUtilShell catalogUtilShell) {
            super(catalogUtil, catalogUtilShell, "save", 1);
        }

        @Override
        public void behaviour(List<String> parameters) throws Exception {
            if (parameters.size() < this.parametersCount)
                throw new Exception("No path detected.");
            this.catalogUtil.save(parameters.get(0));
        }
    }
    //end of SaveCommand class

    /**
     * <p> Clasa LoadCommand defineste comanda load. </p>
     */
    private static class LoadCommand extends CatalogShellCommand {
        public LoadCommand(CatalogUtil catalogUtil, CatalogUtilShell catalogUtilShell) {
            super(catalogUtil, catalogUtilShell, "load", 1);
        }

        @Override
        public void behaviour(List<String> parameters) throws Exception {
            if (parameters.size() < this.parametersCount)
                throw new Exception("No path detected.");
            this.catalogUtil.load(parameters.get(0));
        }
    }
    //end of LoadCommand class

    /**
     * <p> Clasa ListCommand defineste comanda list. </p>
     */
    private static class ListCommand extends CatalogShellCommand {
        public ListCommand(CatalogUtil catalogUtil, CatalogUtilShell catalogUtilShell) {
            super(catalogUtil, catalogUtilShell, "list", 0);
        }

        @Override
        public void behaviour(List<String> parameters) throws Exception {
            System.out.println("Documents already exist.");
            this.catalogUtil.getCatalog().list();
        }
    }
    //end of ListCommand class

    /**
     * <p> Clasa ViewCommand defineste comanda view. </p>
     */
    protected static class ViewCommand extends CatalogShellCommand {
        public ViewCommand(CatalogUtil catalogUtil, CatalogUtilShell catalogUtilShell) {
            super(catalogUtil, catalogUtilShell, "view", 1);
        }

        @Override
        public void behaviour(List<String> parameters) throws Exception {
            if (parameters.size() < this.parametersCount)
                throw new Exception("No path detected.");
            this.catalogUtil.view(parameters.get(0));
        }
    }
    //end of ViewCommand class

    //elementele clasei CatalogUtilShell:

    private CatalogUtil catalogUtil;
    private Scanner scanner;
    private boolean isActive;
    private List<CatalogShellCommand> catalogShellCommandsList;
    private ExitCommand exitCommand;

    public CatalogUtilShell(CatalogUtil catalogUtil, Scanner scanner, boolean isActive, List<CatalogShellCommand> catalogShellCommandsList, ExitCommand exitCommand) {
        this.catalogUtil = catalogUtil;
        this.scanner = scanner;
        this.isActive = isActive;
        this.catalogShellCommandsList = catalogShellCommandsList;
        this.exitCommand = exitCommand;
    }

    public CatalogUtil getCatalogUtil() {
        return catalogUtil;
    }

    public void setCatalogUtil(CatalogUtil catalogUtil) {
        this.catalogUtil = catalogUtil;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<CatalogShellCommand> getCatalogShellCommandsList() {
        return catalogShellCommandsList;
    }

    public void setCatalogShellCommandsList(List<CatalogShellCommand> catalogShellCommandsList) {
        this.catalogShellCommandsList = catalogShellCommandsList;
    }

    public ExitCommand getExitCommand() {
        return exitCommand;
    }

    public void setExitCommand(ExitCommand exitCommand) {
        this.exitCommand = exitCommand;
    }

    //alte functii ajutatoare pentru clasele comenzilor:

    private void parseCommand(String command) throws Exception {
        if (command.startsWith(this.exitCommand.getCommand())) {
            this.exitCommand.behaviour(null);
            return;
        }

        int firstSpace = command.indexOf(' ');
        String comanda;
        String parameter = null;
        if (firstSpace == -1)
            comanda = command;
        else {
            comanda = command.substring(0, firstSpace);
            parameter = command.substring(firstSpace + 1);
        }

        for (var shellCommand : this.catalogShellCommandsList)
            if (shellCommand.getCommand().equals(comanda)) {
                shellCommand.behaviour(parameter == null ? List.of() : List.of(parameter));
                return;
            }

        throw new CommandNotFoundException("Command not found");
    }

    public void initialize() throws Exception {
        if (this.isActive)
            throw new Exception("Shell already started.");

        this.scanner = new Scanner(System.in);
        this.catalogUtil = new CatalogUtil();

        this.isActive = true;

        String command;
        while (this.isActive) {
            System.out.print("Catalog Shell: ");
            command = this.scanner.nextLine();
            try {
                this.parseCommand(command);
            }
            catch (CommandNotFoundException exception) {
                System.out.println("Command not found");
            }
        }
    }

    private void reinitialize() throws Exception {
        if (!this.isActive)
            throw new Exception("Shell already inactive.");

        this.scanner.close();

        this.isActive = false;
    }
}
