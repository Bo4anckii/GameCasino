package sample.models;

public class LoseHandler extends Handler{

    public LoseHandler(Handler processor) {
        super(processor);
    }

    @Override
    public boolean process(int[] request) {
        if(request[0]!=request[1] || request[1]!=request[2]){
            return false;
        } else {
            return super.process(request);
        }
    }
}
