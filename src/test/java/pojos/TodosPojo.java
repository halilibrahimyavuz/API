package pojos;

public class TodosPojo {   //4 asama var
    //1.key value seklınde kı degıskenlerı key lerı PRIVATE olarak tanımla
    private int userId;
    private  int id;
    private  String title;
    private boolean completed;

    //2. bu degerlere ulasabılmek ıcın publıc getter setter methdoları olustur.
    // sag tık yap sonra Generate tıkla getter setter sec

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    //3. parametrelı ve parametresıxz constructor olsutur
    // sag tık yap generate tıkla constructor tıkla acılan secenekten en ustekıne tıkla parametresız constructor olsuturur

    public TodosPojo() {  //parametresız constructor
    }

    public TodosPojo(int userId, int id, String title, boolean completed) {  //parametrelı constructor acılan menuden hepsını sec
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    //4. toString methodu olsutur
    // sag tık generate sec toStrıng sec hesını sec

    @Override
    public String toString() {
        return "TodosPojo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }



    // encapsulatıon seklınde yapıyoruz...




}
