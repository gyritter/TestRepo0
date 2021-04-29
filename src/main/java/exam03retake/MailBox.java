package exam03retake;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public MailBox() {

    }

    public List<Mail> getMails() {
        return mails;
    }


    public List<Mail> findByCriteria(String criteria) {
        List<Mail> result = new ArrayList<>();
        if (criteria.startsWith("from")) {

            for (Mail m : mails) {
                String r1 = m.getFrom().getName();
                String r2 = m.getFrom().getEmail();
                if (r1.equals(criteria.substring(5))) {
                    result.add(m);
                }
                if (r2.equals(criteria.substring(5))) {
                    result.add(m);
                }
            }
        }
        if (criteria.startsWith("to")) {
            for (Mail m : mails) {
                for (Contact c : m.getTo()) {
                    if (c.getEmail().equals(criteria.substring(3))) {
                        result.add(m);
                    }
                    if (c.getName().equals(criteria.substring(3))) {
                        System.out.println(c.getName());
                        result.add(m);
                    }
                }
            }
        }
        for (Mail m : mails) {
            if ((m.getSubject().contains(criteria)) || (m.getMessage().contains(criteria))) {
                result.add(m);
            }
        }
        return result;
    }
    public void addMail(Mail m) {
        mails.add(m);
    }
}
