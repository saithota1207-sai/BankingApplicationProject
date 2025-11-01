package org.example.bankingsystem.Dao;

import org.example.bankingsystem.Entites.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class CardDAO {
    private final List<Card> cards = new ArrayList<>();
    private int idSeq = 1;

    public Card create(Card c) {
        c.setId(idSeq++);
        cards.add(c);
        return c;
    }

    public Optional<Card> findById(int id) {
        return cards.stream().filter(x -> x.getId() == id).findFirst();
    }

    public List<Card> findAll() {
        return new ArrayList<>(cards);
    }

    public boolean delete(int id) {
        return cards.removeIf(c -> c.getId() == id);
    }

}
