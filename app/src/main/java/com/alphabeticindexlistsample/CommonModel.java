package com.alphabeticindexlistsample;

import java.util.Comparator;

public class CommonModel {
    private String contact_name;
    private ContactType contactInfo;
    private boolean isClicked;

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    private String alphabet;

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public ContactType getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactType contactInfo) {
        this.contactInfo = contactInfo;
    }

    public static Comparator<CommonModel> comparator=new Comparator<CommonModel>() {
        @Override
        public int compare(CommonModel o1, CommonModel o2) {
            String contact1 = String.valueOf(o1.getContact_name().toLowerCase());
            String contact2 = String.valueOf(o2.getContact_name().toLowerCase());

            //ascending order
            return contact1.compareTo(contact2);

        }
    };

    public static class ContactType {
        private String contact_number;
        private String type;

        public String getContact_number() {
            return contact_number;
        }

        public void setContact_number(String contact_number) {
            this.contact_number = contact_number;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }


    }
}
