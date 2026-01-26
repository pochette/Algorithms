package SeventhSprintPractice;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class UserPost {
    private String photoUrl;
    private LocalDateTime postTime;
    private String userId;
    private String description;
    private int likesQuantity;

    public UserPost(String photoUrl, LocalDateTime postTime, String userId, String description, int likesQuantity) {
        this.photoUrl = photoUrl;
        this.postTime = postTime;
        this.userId = userId;
        this.description = description;
        this.likesQuantity = likesQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikesQuantity() {
        return likesQuantity;
    }

    public void setLikesQuantity(int likesQuantity) {
        this.likesQuantity = likesQuantity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
