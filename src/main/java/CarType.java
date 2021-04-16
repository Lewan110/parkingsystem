import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
enum CarType {

    BIG(1,3),
    MEDIUM(2,2),
    SMALL(3,1);

    private final int id;
    private final int size;
}
