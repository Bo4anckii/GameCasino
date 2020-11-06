package sample.models;

public abstract class Handler  {
    private Handler processor;

    public Handler(Handler processor){
        this.processor = processor;
    }

    public boolean process(int[] request){
        if(processor != null)
            return processor.process(request);
        else
            return true;
    }
}