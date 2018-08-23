public class Worker extends Thread{

    private boolean run;
    private Data data;

    public Worker() {
        run = true;
        data = new Data();
        init();
    }

    @Override
    public void run() {
        while(run) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String html = data.getHtml();
        }
    }

    private void init() {

    }
}
