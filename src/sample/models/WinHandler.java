package sample.models;

public class WinHandler extends Handler{

    public WinHandler(Handler processor) {
        super(processor);
    }

    @Override
    public boolean process(int[] request) {
        if(request[0] == request[1] || request[1] == request[2]){
            return true;
        } else {
            return super.process(request);
        }
    }
}
