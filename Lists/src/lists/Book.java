
package lists;

public class Book {
    private String name;
    private String autor;
    private String code;
    
    public Book (String name, String autor, String code){
        this.name = name;
        this.autor = autor;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getAutor() {
        return autor;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
