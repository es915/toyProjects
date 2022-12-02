package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        // id 값이 없는경우 -> 새로 등록할 아이템
        if (item.getId() == null) {
            em.persist(item);
        } else { // id 값이 있는 경우 -> DB에서 수정하려고 가져온 객체
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> finAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

}
