package frame;

import java.util.List;

public interface Db<Key, Value> {
    void insert(Value value) throws Exception;
    void update(Value value) throws Exception;
    void delete(Key key) throws Exception;
    Value select(Key key)   throws Exception;
    List<Value> select() throws Exception;

    default List<Value> searchByName(String name) throws Exception {
        return null;
    }
}
