package com.pobitecoding.Instance;

import java.util.Date;
import java.util.Objects;

public class Book implements Comparable<Book>, Cloneable {
    private String title;
    private Date publishDate;
    private String comment;
    
    public Book(String title, Date publishDate, String comment) {
        this.title = title;
        this.publishDate = publishDate;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getComment() {
        return comment;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishDate, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(publishDate, other.publishDate)
                && Objects.equals(title, other.title);
    }

    @Override
    public int compareTo(Book o) {
        
        if (this.publishDate.getTime() < o.publishDate.getTime()) {
            return -1;
        }
        else {
            
            if (this.publishDate.getTime() == o.publishDate.getTime()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    
    @Override
    public Book clone() {
        Book result = new Book(this.title, this.publishDate, this.comment);
        return result;
    }

    @Override
    public String toString() {
        return "[제목=" + title + ", 출간일=" + publishDate + ", 댓글=" + comment
                + "]";
    }
}
