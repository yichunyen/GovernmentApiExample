package yichunyen.governmentapi.example;

/**
 * Created by yichun on 8/30/18.
 */

public interface Base {
    interface View<T extends Presenter> {

        void setPresenter(T presenter);

    }

    interface Presenter {

        void start();

        void stop();

    }
}
