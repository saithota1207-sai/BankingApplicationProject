package org.example.bankingsystem.Entites;

public class Card {

        private int id;
        private int accountId;
        private String cardNumber;
        private String cardType;
        private String expiry;

        public Card() {}

        public Card(int id, int accountId, String cardNumber, String cardType, String expiry) {
            this.id = id;
            this.accountId = accountId;
            this.cardNumber = cardNumber;
            this.cardType = cardType;
            this.expiry = expiry;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public int getAccountId() { return accountId; }
        public void setAccountId(int accountId) { this.accountId = accountId; }

        public String getCardNumber() { return cardNumber; }
        public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

        public String getCardType() { return cardType; }
        public void setCardType(String cardType) { this.cardType = cardType; }

        public String getExpiry() { return expiry; }
        public void setExpiry(String expiry) { this.expiry = expiry; }

        @Override
        public String toString() {
            return "Card{" +
                    "id=" + id +
                    ", accountId=" + accountId +
                    ", cardNumber='" + cardNumber + '\'' +
                    ", cardType='" + cardType + '\'' +
                    ", expiry='" + expiry + '\'' +
                    '}';
        }
    }


