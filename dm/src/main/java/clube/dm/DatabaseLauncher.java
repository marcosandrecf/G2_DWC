package clube.dm;

import clube.dm.config.DatabaseInitializer;

public class DatabaseLauncher {

    public static void main(String[] args) {
        DatabaseInitializer.criarBancoSeNaoExistir();

    }
}