package org.example.bankingsystem.Service;



import org.example.bankingsystem.Dao.CardDAO;
import org.example.bankingsystem.Entites.Card;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CardService {
    private final CardDAO dao = new CardDAO();

    public Card issueCard(int accountId, String cardType, String expiry) {
        String cardNo = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
        Card c = new Card(0, accountId, cardNo, cardType, expiry);
        return dao.create(c);
    }

    public Optional<Card> getCard(int id) { return dao.findById(id); }
    public List<Card> getAll() { return dao.findAll(); }
    public boolean cancelCard(int id) { return dao.delete(id); }
}

