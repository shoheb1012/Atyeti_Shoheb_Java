package liskov_substitution_principle;

public class Facebook extends SocialMedia{
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost() {

    }

    @Override
    public void senPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall(String... users) {

    }
}

//this facebook substitue of  parent class(social media) all the functionality from pareant and child are substitute with each other
