package BasBks.RBPOproj.models;

import jakarta.persistence.*;

@Entity
public class Service {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String ServiceName, ServiceRole;

    private int Likes;

    private String iconName, backgroundName;

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getBackgroundName() {
        return backgroundName;
    }

    public void setBackgroundName(String backgroundName) {
        this.backgroundName = backgroundName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getServiceRole() {
        return ServiceRole;
    }

    public void setServiceRole(String serviceRole) {
        ServiceRole = serviceRole;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }

    public Service() {
    }

    public Service(String serviceName, String serviceRole) {
        ServiceName = serviceName;
        ServiceRole = serviceRole;
    }
}
