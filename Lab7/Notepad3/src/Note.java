
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Note implements Serializable {
    private String title;
    private String note;
    private String date;

    /**
     *constructor of Note
     * date of note is current date as string
     * @param title
     * @param note
     */
    public Note(String title,String note){
        this.title = title;
        this.note = note;
        date = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
    }

    /**
     * return title of note
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * set title of note with given string
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * return text of the note
     * @return
     */
    public String getNote() {
        return note;
    }

    /**
     * set text of note with given string
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * get date of a note
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * set date of a note by given string
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
}
