public class Main {
    private final Object flag = new Object();
    private Integer count = 0;

    static void main(String[] args) {

    }
    
    //----//

    void oneThread() {
        Main main = new Main();
        // один поток
        main.doOperation(0);
        main.doOperation(1);
        main.doOperation(2);
        main.doOperation(3);
        main.doOperation(4);
        main.doOperation(5);
        main.doOperation(6);
        main.doOperation(7);
        main.doOperation(8);
        main.doOperation(9);
//        Operation 0
//        Operation 1
//        Operation 2
//        Operation 3
//        Operation 4
//        Operation 5
//        Operation 6
//        Operation 7
//        Operation 8
//        Operation 9
    }

    void threeThreads() {
        Main main = new Main();
        // три потока
        main.doOperation(0);
        main.doOperation(1);

        new Thread(() -> {
            main.doOperation(2);
            main.doOperation(3);
            main.doOperation(4);
        }).start();

        main.doOperation(5);

        new Thread(() -> {
            main.doOperation(6);
            main.doOperation(7);
            main.doOperation(8);
        }).start();

        main.doOperation(9);

//        Operation 0
//        Operation 1
//        Operation 5
//        Operation 2
//        Operation 9
//        Operation 6
//        Operation 3
//        Operation 7
//        Operation 4
//        Operation 8
    }

    void threeThreadsDoOperationSynchronized() {
        Main main = new Main();
        // три потока
        main.doOperationSynchronized(0);
        main.doOperationSynchronized(1);

        new Thread(() -> {
            main.doOperationSynchronized(2);
            main.doOperationSynchronized(3);
            main.doOperationSynchronized(4);
        }).start();

        main.doOperationSynchronized(5);

        new Thread(() -> {
            main.doOperationSynchronized(6);
            main.doOperationSynchronized(7);
            main.doOperationSynchronized(8);
        }).start();

        main.doOperationSynchronized(9);

        //Operation 0 Count 0
        //Operation 1 Count 1
        //Operation 5 Count 2
        //Operation 2 Count 3
        //Operation 3 Count 4
        //Operation 4 Count 5
        //Operation 9 Count 6
        //Operation 6 Count 7
        //Operation 7 Count 8
        //Operation 8 Count 9
    }

    void threeThreadDoOperationSynchronizedBlock() {
        Main main = new Main();
        // три потока
        main.doOperationSynchronizedBlock(0);
        main.doOperationSynchronizedBlock(1);

        new Thread(() -> {
            main.doOperationSynchronizedBlock(2);
            main.doOperationSynchronizedBlock(3);
            main.doOperationSynchronizedBlock(4);
        }).start();

        main.doOperationSynchronizedBlock(5);

        new Thread(() -> {
            main.doOperationSynchronizedBlock(6);
            main.doOperationSynchronizedBlock(7);
            main.doOperationSynchronizedBlock(8);
        }).start();

        main.doOperationSynchronizedBlock(9);

        //Operation 0 Count 0
        //Operation 1 Count 1
        //Operation 5 Count 2
        //Operation 2 Count 3
        //Operation 9 Count 4
        //Operation 6 Count 5
        //Operation 3 Count 6
        //Operation 4 Count 7
        //Operation 7 Count 8
        //Operation 8 Count 9
    }
    
    //----//

    private void doOperation(Integer numberOperation) {
        System.out.println("Operation " + numberOperation);
        String s = "";
        for (int i = 0; i < 100_000; i++) {
            s += i;
        }
    }

    private synchronized void doOperationSynchronized(Integer numberOperation) {
        // он будет выполнятся в одном потоке, а другие потоки будут ждать выполнения одного потока, чтобы ыперенять задачу на себя
        // ну то есть потоки будут работать не одновременно, а по очереди.
        // По сути, тут будет несколько потоков, выполняющих действия за то же время, за сколько будет выполнять один поток.
        // Следовательно смысла от распарралееливания не будет.
        synchronized (flag) {
            System.out.println("Operation " + numberOperation + " Count " + count);
            count++;
        }
        String s = "";
        for (int i = 0; i < 100_000; i++) {
            s += i;
        }
    }

    private void doOperationSynchronizedBlock(Integer numberOperation) {
        // То есть второй поток пока первый занимает блок synchronized выполняет конкатенацию строк,
        // потом он выполняет блок synchronized, как тот освободился, то есть flag методом notify класса Object уведомил его об окончании работ в блоке.
        synchronized (flag) {
            System.out.println("Operation " + numberOperation + " Count " + count);
            count++;
        }

        String s = "";
        for (int i = 0; i < 100_000; i++) {
            s += i;
        }
    }

    // Ну и потом дальше сами подумайте, если написать if(Tread.interrupted()) { throw new RuntimeException() или  System.out.println("Tread interrupted") }
}