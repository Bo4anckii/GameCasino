package sample.models;

public class ActionChain {
    private Handler chain;

    public ActionChain(){
        buildChain();
    }

    private void buildChain(){
        chain = new LoseHandler(new WinHandler(null));
    }

    public boolean process(int[] request){
        return chain.process(request);
    }
}
