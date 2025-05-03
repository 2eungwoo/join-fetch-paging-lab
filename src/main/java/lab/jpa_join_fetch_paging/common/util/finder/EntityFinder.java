package lab.jpa_join_fetch_paging.common.util.finder;

public interface EntityFinder<T, ID> {
    T findByIdOrThrow(ID id);
}