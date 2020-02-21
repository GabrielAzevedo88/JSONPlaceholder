import com.android.jsonplaceholder.post.model.Album
import com.android.jsonplaceholder.post.model.Comment
import com.android.jsonplaceholder.post.model.Photo
import com.android.jsonplaceholder.post.model.Post
import com.android.jsonplaceholder.repository.JsonPlaceholderDataContract
import com.android.jsonplaceholder.repository.JsonPlaceholderService
import com.android.jsonplaceholder.repository.SafeRequest
import com.android.jsonplaceholder.user.model.User

class JsonPlaceholderRepository(private val service: JsonPlaceholderService) :
    JsonPlaceholderDataContract,
    SafeRequest() {

    override suspend fun getPosts(): List<Post> = apiRequest {
        service.getPosts()
    }

    override suspend fun getPost(id: Int): Post = apiRequest {
        service.getPost(id)
    }

    override suspend fun getUsers(): List<User> = apiRequest {
        service.getUsers()
    }

    override suspend fun getPostComments(postId: Int): List<Comment> = apiRequest {
        service.getPostComments(postId)
    }

    override suspend fun getUserAlbums(userId: Int): List<Album> = apiRequest {
        service.getUserAlbums(userId)
    }

    override suspend fun getPhotos(albumId: Int): List<Photo> = apiRequest {
        service.getPhotos(albumId)
    }
}