package khorsun.app.utill;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<K,T> {
    T show(int id);



    List<T> index();


    T save(T object);

    T update(T object);

    K delete(K id);
}
