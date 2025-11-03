package liskov_substitution_principle;

public abstract class SocialMedia {

    public abstract void chatWithFriend();

    public abstract void publishPost();

    public abstract void senPhotosAndVideos();

    public abstract void groupVideoCall(String... users);
}
