package br.edu.curso.dubles.stub.exemplo.facebook;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.edu.curso.dubles.snippet.Properties;
import facebook4j.Account;
import facebook4j.Achievement;
import facebook4j.Activity;
import facebook4j.Admin;
import facebook4j.Album;
import facebook4j.AlbumUpdate;
import facebook4j.BackdatingPostUpdate;
import facebook4j.Book;
import facebook4j.Checkin;
import facebook4j.CheckinUpdate;
import facebook4j.Comment;
import facebook4j.Domain;
import facebook4j.Event;
import facebook4j.EventUpdate;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Family;
import facebook4j.Friend;
import facebook4j.FriendRequest;
import facebook4j.Friendlist;
import facebook4j.Game;
import facebook4j.GeoLocation;
import facebook4j.Group;
import facebook4j.GroupDoc;
import facebook4j.GroupMember;
import facebook4j.InboxResponseList;
import facebook4j.Insight;
import facebook4j.Interest;
import facebook4j.Like;
import facebook4j.Link;
import facebook4j.Location;
import facebook4j.Media;
import facebook4j.Message;
import facebook4j.Milestone;
import facebook4j.MilestoneUpdate;
import facebook4j.Movie;
import facebook4j.Music;
import facebook4j.Note;
import facebook4j.Notification;
import facebook4j.Offer;
import facebook4j.OfferUpdate;
import facebook4j.Page;
import facebook4j.PageCoverUpdate;
import facebook4j.PagePhotoUpdate;
import facebook4j.PageSetting;
import facebook4j.PageSettingUpdate;
import facebook4j.PageUpdate;
import facebook4j.Paging;
import facebook4j.Permission;
import facebook4j.Photo;
import facebook4j.PhotoUpdate;
import facebook4j.PictureSize;
import facebook4j.Place;
import facebook4j.Poke;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.Question;
import facebook4j.Question.Option;
import facebook4j.QuestionUpdate;
import facebook4j.QuestionVotes;
import facebook4j.RSVPStatus;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.Score;
import facebook4j.Subscribedto;
import facebook4j.Subscriber;
import facebook4j.Tab;
import facebook4j.TabUpdate;
import facebook4j.Tag;
import facebook4j.TagUpdate;
import facebook4j.Tagged;
import facebook4j.Television;
import facebook4j.TestUser;
import facebook4j.User;
import facebook4j.Video;
import facebook4j.VideoUpdate;
import facebook4j.api.AccountMethods;
import facebook4j.api.ActivityMethods;
import facebook4j.api.AlbumMethods;
import facebook4j.api.CheckinMethods;
import facebook4j.api.CommentMethods;
import facebook4j.api.DomainMethods;
import facebook4j.api.EventMethods;
import facebook4j.api.FQLMethods;
import facebook4j.api.FamilyMethods;
import facebook4j.api.FavoriteMethods;
import facebook4j.api.FriendMethods;
import facebook4j.api.GameMethods;
import facebook4j.api.GroupMethods;
import facebook4j.api.InsightMethods;
import facebook4j.api.LikeMethods;
import facebook4j.api.LinkMethods;
import facebook4j.api.LocationMethods;
import facebook4j.api.MessageMethods;
import facebook4j.api.NoteMethods;
import facebook4j.api.NotificationMethods;
import facebook4j.api.PageMethods;
import facebook4j.api.PermissionMethods;
import facebook4j.api.PhotoMethods;
import facebook4j.api.PokeMethods;
import facebook4j.api.PostMethods;
import facebook4j.api.QuestionMethods;
import facebook4j.api.SearchMethods;
import facebook4j.api.SubscribeMethods;
import facebook4j.api.TestUserMethods;
import facebook4j.api.UserMethods;
import facebook4j.api.VideoMethods;
import facebook4j.auth.AccessToken;
import facebook4j.auth.Authorization;
import facebook4j.conf.Configuration;
import facebook4j.internal.org.json.JSONArray;
import facebook4j.internal.org.json.JSONObject;

@SuppressWarnings("unchecked")
public class FacebookStub implements Facebook {

	private static final long serialVersionUID = -1982465428432808532L;

	public void setOAuthAppId(String appId, String appSecret) {
		// TODO Auto-generated method stub
	}

	public void setOAuthPermissions(String permissions) {
		// TODO Auto-generated method stub
		
	}

	public String getOAuthAuthorizationURL(String callbackURL) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOAuthAuthorizationURL(String callbackURL, String state) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessToken getOAuthAccessToken() {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessToken getOAuthAccessToken(String oauthCode)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessToken getOAuthAppAccessToken() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOAuthAccessToken(AccessToken accessToken) {
		// TODO Auto-generated method stub
		
	}

	public String getId() throws FacebookException, IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() throws FacebookException, IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Authorization getAuthorization() {
		// TODO Auto-generated method stub
		return null;
	}

	public Configuration getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> ResponseList<T> fetchNext(Paging<T> paging)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> ResponseList<T> fetchPrevious(Paging<T> paging)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	public User getMe() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public User getMe(Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getPictureURL() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getPictureURL(PictureSize size) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getPictureURL(String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getPictureURL(String userId, PictureSize size)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getSSLPictureURL() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getSSLPictureURL(PictureSize size) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getSSLPictureURL(String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getSSLPictureURL(String userId, PictureSize size)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUsers(String... ids) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Account> getAccounts() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Account> getAccounts(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Account> getAccounts(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Account> getAccounts(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Activity> getActivities() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Activity> getActivities(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Activity> getActivities(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Activity> getActivities(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Album> getAlbums() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Album> getAlbums(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Album> getAlbums(String id) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Album> getAlbums(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createAlbum(AlbumUpdate albumUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createAlbum(String userId, AlbumUpdate albumUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Album getAlbum(String albumId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Album getAlbum(String albumId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Photo> getAlbumPhotos(String albumId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Photo> getAlbumPhotos(String albumId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String addAlbumPhoto(String albumId, Media source)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String addAlbumPhoto(String albumId, Media source, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getAlbumComments(String albumId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getAlbumComments(String albumId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String commentAlbum(String albumId, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getAlbumLikes(String albumId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getAlbumLikes(String albumId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean likeAlbum(String albumId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unlikeAlbum(String albumId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public URL getAlbumCoverPhoto(String albumId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Checkin> getCheckins() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Checkin> getCheckins(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Checkin> getCheckins(String id)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Checkin> getCheckins(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String checkin(CheckinUpdate checkinUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String checkin(String userId, CheckinUpdate checkinUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Checkin getCheckin(String checkinId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Checkin getCheckin(String checkinId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getCheckinComments(String checkinId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getCheckinComments(String checkinId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String commentCheckin(String checkinId, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getCheckinLikes(String checkinId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getCheckinLikes(String checkinId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean likeCheckin(String checkinId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unlikeCheckin(String checkinId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public Comment getComment(String commentId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteComment(String commentId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Like> getCommentLikes(String commentId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getCommentLikes(String commentId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean likeComment(String commentId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unlikeComment(String commentId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public Domain getDomain(String domainId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Domain getDomainByName(String domainName) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Domain> getDomainsByName(String... domainName)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Event> getEvents() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Event> getEvents(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Event> getEvents(String id) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Event> getEvents(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createEvent(EventUpdate eventUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createEvent(String id, EventUpdate eventUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean editEvent(String eventId, EventUpdate eventUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteEvent(String eventId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public Event getEvent(String eventId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Event getEvent(String eventId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postEventLink(String eventId, URL link)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postEventLink(String eventId, URL link, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postEventStatusMessage(String eventId, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<RSVPStatus> getRSVPStatusAsNoreply(String eventId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<RSVPStatus> getRSVPStatusAsNoreply(String eventId,
			String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<RSVPStatus> getRSVPStatusAsInvited(String eventId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<RSVPStatus> getRSVPStatusAsInvited(String eventId,
			String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean inviteToEvent(String eventId, String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean inviteToEvent(String eventId, String[] userIds)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean uninviteFromEvent(String eventId, String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<RSVPStatus> getRSVPStatusInAttending(String eventId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<RSVPStatus> getRSVPStatusInAttending(String eventId,
			String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean rsvpEventAsAttending(String eventId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<RSVPStatus> getRSVPStatusInMaybe(String eventId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<RSVPStatus> getRSVPStatusInMaybe(String eventId,
			String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean rsvpEventAsMaybe(String eventId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<RSVPStatus> getRSVPStatusInDeclined(String eventId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<RSVPStatus> getRSVPStatusInDeclined(String eventId,
			String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean rsvpEventAsDeclined(String eventId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public URL getEventPictureURL(String eventId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getEventPictureURL(String eventId, PictureSize size)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEventPicture(String eventId, Media source)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteEventPicture(String eventId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Photo> getEventPhotos(String eventId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Photo> getEventPhotos(String eventId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postEventPhoto(String eventId, Media source)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postEventPhoto(String eventId, Media source, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Video> getEventVideos(String eventId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Video> getEventVideos(String eventId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postEventVideo(String eventId, Media source)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postEventVideo(String eventId, Media source, String title,
			String description) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Family> getFamily() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Family> getFamily(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Family> getFamily(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Family> getFamily(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Book> getBooks() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Book> getBooks(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Book> getBooks(String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Book> getBooks(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Game> getGames() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Game> getGames(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Game> getGames(String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Game> getGames(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Movie> getMovies() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Movie> getMovies(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Movie> getMovies(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Movie> getMovies(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Music> getMusic() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Music> getMusic(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Music> getMusic(String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Music> getMusic(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Television> getTelevision() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Television> getTelevision(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Television> getTelevision(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Television> getTelevision(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Interest> getInterests() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Interest> getInterests(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Interest> getInterests(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Interest> getInterests(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getFriends() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getFriends(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getFriends(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getFriends(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getBelongsFriend(String friendId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getBelongsFriend(String friendId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getBelongsFriend(String userId, String friendId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getBelongsFriend(String userId,
			String friendId, Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friendlist> getFriendlists() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friendlist> getFriendlists(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friendlist> getFriendlists(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friendlist> getFriendlists(String userId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createFriendlist(String friendlistName)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createFriendlist(String userId, String friendlistName)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Friendlist getFriendlist(String friendlistId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Friendlist getFriendlist(String friendlistId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteFriendlist(String friendlistId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Friend> getFriendlistMembers(String friendlistId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addFriendlistMember(String friendlistId, String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeFriendlistMember(String friendlistId, String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<FriendRequest> getFriendRequests()
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<FriendRequest> getFriendRequests(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<FriendRequest> getFriendRequests(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<FriendRequest> getFriendRequests(String userId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getMutualFriends(String friendUserId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getMutualFriends(String friendUserId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getMutualFriends(String userId1, String userId2)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Friend> getMutualFriends(String userId1,
			String userId2, Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Achievement> getAchievements() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Achievement> getAchievements(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Achievement> getAchievements(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Achievement> getAchievements(String userId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postAchievement(URL achievementURL) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postAchievement(String userId, URL achievementURL)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteAchievement(URL achievementURL)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAchievement(String userId, URL achievementURL)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Score> getScores() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Score> getScores(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Score> getScores(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Score> getScores(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean postScore(int scoreValue) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean postScore(String userId, int scoreValue)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteScore() throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteScore(String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Group> getGroups() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Group> getGroups(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Group> getGroups(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Group> getGroups(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Group getGroup(String groupId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Group getGroup(String groupId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getGroupFeed(String groupId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getGroupFeed(String groupId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postGroupFeed(String groupId, PostUpdate postUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postGroupLink(String groupId, URL link)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postGroupLink(String groupId, URL link, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postGroupStatusMessage(String groupId, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<GroupMember> getGroupMembers(String groupId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<GroupMember> getGroupMembers(String groupId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getGroupPictureURL(String groupId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<GroupDoc> getGroupDocs(String groupId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<GroupDoc> getGroupDocs(String groupId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getUserLikes() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getUserLikes(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getUserLikes(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getUserLikes(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Link> getLinks() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Link> getLinks(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Link> getLinks(String id) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Link> getLinks(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Link getLink(String linkId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Link getLink(String linkId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getLinkComments(String linkId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getLinkComments(String linkId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String commentLink(String linkId, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getLinkLikes(String linkId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getLinkLikes(String linkId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean likeLink(String linkId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unlikeLink(String linkId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Location> getLocations() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Location> getLocations(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Location> getLocations(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Location> getLocations(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public InboxResponseList<Message> getInbox() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public InboxResponseList<Message> getInbox(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public InboxResponseList<Message> getInbox(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public InboxResponseList<Message> getInbox(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Message> getOutbox() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Message> getOutbox(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Message> getOutbox(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Message> getOutbox(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Message> getUpdates() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Message> getUpdates(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Message> getUpdates(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Message> getUpdates(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Message getMessage(String messageId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Message getMessage(String messageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Note> getNotes() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Note> getNotes(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Note> getNotes(String id) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Note> getNotes(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createNote(String subject, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createNote(String id, String subject, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Note getNote(String noteId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Note getNote(String noteId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getNoteComments(String noteId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getNoteComments(String noteId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String commentNote(String noteId, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getNoteLikes(String noteId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getNoteLikes(String noteId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean likeNote(String noteId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unlikeNote(String noteId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Notification> getNotifications()
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Notification> getNotifications(boolean includeRead)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Notification> getNotifications(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Notification> getNotifications(Reading reading,
			boolean includeRead) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Notification> getNotifications(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Notification> getNotifications(String userId,
			boolean includeRead) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Notification> getNotifications(String userId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Notification> getNotifications(String userId,
			Reading reading, boolean includeRead) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean markNotificationAsRead(String notificationId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public Page getPage() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Page getPage(Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Page getPage(String pageId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Page getPage(String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getPagePictureURL() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getPagePictureURL(PictureSize size) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getPagePictureURL(String pageId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getPagePictureURL(String pageId, PictureSize size)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getPromotablePosts() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getPromotablePosts(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getPromotablePosts(String pageId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getPromotablePosts(String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updatePageBasicAttributes(PageUpdate pageUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePageBasicAttributes(String pageId,
			PageUpdate pageUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePageProfilePhoto(URL picture) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePageProfilePhoto(String pageId, URL picture)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePageProfilePhoto(Media source)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePageProfilePhoto(String pageId, Media source)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePageCoverPhoto(PageCoverUpdate pageCoverUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePageCoverPhoto(String pageId,
			PageCoverUpdate pageCoverUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean displayPagePost(String postId, boolean isHidden)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<PageSetting> getPageSettings() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<PageSetting> getPageSettings(String pageId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updatePageSetting(PageSettingUpdate pageSettingUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePageSetting(String pageId,
			PageSettingUpdate pageSettingUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public String postBackdatingFeed(BackdatingPostUpdate backdatingPostUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postBackdatingFeed(String pageId,
			BackdatingPostUpdate backdatingPostUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postPagePhoto(PagePhotoUpdate pagePhotoUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postPagePhoto(String pageId, PagePhotoUpdate pagePhotoUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Page> getGlobalBrandChildren(String pageId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Page> getGlobalBrandChildren(String pageId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Insight> getPageInsights(String pageId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Insight> getPageInsights(String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tagged> getPageTagged(String pageId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tagged> getPageTagged(String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Milestone> getMilestones() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Milestone> getMilestones(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Milestone> getMilestones(String pageId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Milestone> getMilestones(String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createMilestone(MilestoneUpdate milestoneUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createMilestone(String pageId, MilestoneUpdate milestoneUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteMilestone(String milestoneId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Admin> getPageAdmins() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Admin> getPageAdmins(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Admin> getPageAdmins(String pageId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Admin> getPageAdmins(String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tab> getTabs() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tab> getTabs(Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tab> getTabs(String pageId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tab> getTabs(String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tab> getInstalledTabs(List<String> appIds)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tab> getInstalledTabs(List<String> appIds,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tab> getInstalledTabs(String pageId, List<String> appIds)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tab> getInstalledTabs(String pageId,
			List<String> appIds, Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean installTab(String appId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean installTab(String pageId, String appId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateTab(String tabId, TabUpdate tabUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateTab(String pageId, String tabId, TabUpdate tabUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteTab(String tabId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteTab(String pageId, String tabId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<User> getBlocked() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<User> getBlocked(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<User> getBlocked(String pageId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<User> getBlocked(String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Boolean> block(List<String> userIds)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Boolean> block(String pageId, List<String> userIds)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean unblock(String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unblock(String pageId, String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Offer> getOffers() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Offer> getOffers(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Offer> getOffers(String pageId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Offer> getOffers(String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createOffer(OfferUpdate offerUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createOffer(String pageId, OfferUpdate offerUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteOffer(String offerId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public Offer getOffer(String offerId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Page getLikedPage(String pageId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Page getLikedPage(String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Page getLikedPage(String userId, String pageId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Page getLikedPage(String userId, String pageId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Permission> getPermissions() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Permission> getPermissions(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean revokePermission(String permissionName)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean revokePermission(String userId, String permissionName)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Photo> getUploadedPhotos() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Photo> getUploadedPhotos(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Photo> getUploadedPhotos(String id)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Photo> getUploadedPhotos(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Photo> getPhotos() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Photo> getPhotos(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Photo> getPhotos(String id) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Photo> getPhotos(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postPhoto(Media source) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postPhoto(PhotoUpdate photoUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postPhoto(String userId, Media source)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postPhoto(String userId, PhotoUpdate photoUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deletePhoto(String photoId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public Photo getPhoto(String photoId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Photo getPhoto(String photoId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getPhotoComments(String photoId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getPhotoComments(String photoId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String commentPhoto(String photoId, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getPhotoLikes(String photoId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getPhotoLikes(String photoId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean likePhoto(String photoId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unlikePhoto(String photoId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public URL getPhotoURL(String photoId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tag> getTagsOnPhoto(String photoId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Tag> getTagsOnPhoto(String photoId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addTagToPhoto(String photoId, String toUserId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addTagToPhoto(String photoId, List<String> toUserIds)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addTagToPhoto(String photoId, TagUpdate tagUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateTagOnPhoto(String photoId, TagUpdate tagUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteTagOnPhoto(String photoId, String toUserId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Poke> getPokes() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Poke> getPokes(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Poke> getPokes(String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Poke> getPokes(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getFeed() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getFeed(Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getFeed(String id) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getFeed(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getHome() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getHome(Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getPosts() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getPosts(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getPosts(String id) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getPosts(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getStatuses() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getStatuses(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getStatuses(String id) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getStatuses(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getTagged() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getTagged(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getTagged(String userId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> getTagged(String userId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Post getPost(String postId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Post getPost(String postId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getPostComments(String postId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getPostComments(String postId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String commentPost(String postId, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getPostLikes(String postId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getPostLikes(String postId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean likePost(String postId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unlikePost(String postId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public String postFeed(PostUpdate postUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postFeed(String id, PostUpdate postUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postLink(URL link) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postLink(URL link, String message) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postLink(String userId, URL link) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postLink(String userId, URL link, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postStatusMessage(String message) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postStatusMessage(String id, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deletePost(String postId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Question> getQuestions() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Question> getQuestions(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Question> getQuestions(String id)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Question> getQuestions(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createQuestion(QuestionUpdate questionUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createQuestion(String id, QuestionUpdate questionUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Question getQuestion(String questionId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Question getQuestion(String questionId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteQuestion(String questionId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Option> getQuestionOptions(String questionId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Option> getQuestionOptions(String questionId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String addQuestionOption(String questionId, String optionDescription)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<QuestionVotes> getQuestionOptionVotes(String questionId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Subscribedto> getSubscribedto()
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Subscribedto> getSubscribedto(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Subscribedto> getSubscribedto(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Subscribedto> getSubscribedto(String userId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Subscriber> getSubscribers() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Subscriber> getSubscribers(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Subscriber> getSubscribers(String userId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Subscriber> getSubscribers(String userId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Video> getVideos() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Video> getVideos(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Video> getVideos(String id) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Video> getVideos(String id, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postVideo(VideoUpdate videoUpdate) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String postVideo(String id, VideoUpdate videoUpdate)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Video getVideo(String videoId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Video getVideo(String videoId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getVideoLikes(String videoId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Like> getVideoLikes(String videoId, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean likeVideo(String videoId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unlikeVideo(String videoId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseList<Comment> getVideoComments(String videoId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Comment> getVideoComments(String videoId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String commentVideo(String videoId, String message)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getVideoCover(String videoId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Insight> getInsights(String objectId, String metric)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Insight> getInsights(String objectId, String metric,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> searchPosts(String query)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Post> searchPosts(String query, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResponseList<User> searchUsers(String query) throws FacebookException {
		ResponseList<User> pessoas = mock( ResponseList.class );
		User megan = apenasMeganFox();
		pessoas.add( megan );
		when( pessoas.get(Properties.FIRST_ELEMENT) ).thenReturn( megan );
		return pessoas;
	}
	
	private User apenasMeganFox() {
		User megan = mock( User.class );
		when( megan.getName() ).thenReturn( "Megan Fox" );
		when( megan.getEmail() ).thenReturn( "megafox@hollywood.com" );
		return megan;
	}

	public ResponseList<User> searchUsers(String query, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Event> searchEvents(String query)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Event> searchEvents(String query, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Group> searchGroups(String query)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Group> searchGroups(String query, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Place> searchPlaces(String query)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Place> searchPlaces(String query, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Place> searchPlaces(String query, GeoLocation center,
			int distance) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Place> searchPlaces(String query, GeoLocation center,
			int distance, Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Checkin> searchCheckins() throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Checkin> searchCheckins(Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Location> searchLocations(GeoLocation center,
			int distance) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Location> searchLocations(GeoLocation center,
			int distance, Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Location> searchLocations(String placeId)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Location> searchLocations(String placeId,
			Reading reading) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Page> searchPages(String query)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<Page> searchPages(String query, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<JSONObject> search(String query)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseList<JSONObject> search(String query, Reading reading)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public TestUser createTestUser(String appId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public TestUser createTestUser(String appId, String name, String locale,
			String permissions) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TestUser> getTestUsers(String appId) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteTestUser(String testUserId) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean makeFriendTestUser(TestUser testUser1, TestUser testUser2)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public JSONArray executeFQL(String query) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONArray executeFQL(String query, Locale locale)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, JSONArray> executeMultiFQL(Map<String, String> queries)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, JSONArray> executeMultiFQL(Map<String, String> queries,
			Locale locale) throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessToken getOAuthAccessToken(String arg0, String arg1)
			throws FacebookException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOAuthCallbackURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOAuthCallbackURL(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean deleteFriendlistMember(String arg0, String arg1)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePermission(String arg0) throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePermission(String arg0, String arg1)
			throws FacebookException {
		// TODO Auto-generated method stub
		return false;
	}

	public AccountMethods accounts() {
		// TODO Auto-generated method stub
		return null;
	}

	public ActivityMethods activities() {
		// TODO Auto-generated method stub
		return null;
	}

	public AlbumMethods albums() {
		// TODO Auto-generated method stub
		return null;
	}

	public CheckinMethods checkins() {
		// TODO Auto-generated method stub
		return null;
	}

	public CommentMethods comments() {
		// TODO Auto-generated method stub
		return null;
	}

	public DomainMethods domains() {
		// TODO Auto-generated method stub
		return null;
	}

	public EventMethods events() {
		// TODO Auto-generated method stub
		return null;
	}

	public FamilyMethods family() {
		// TODO Auto-generated method stub
		return null;
	}

	public FavoriteMethods favorites() {
		// TODO Auto-generated method stub
		return null;
	}

	public FQLMethods fql() {
		// TODO Auto-generated method stub
		return null;
	}

	public FriendMethods friends() {
		// TODO Auto-generated method stub
		return null;
	}

	public GameMethods games() {
		// TODO Auto-generated method stub
		return null;
	}

	public GroupMethods groups() {
		// TODO Auto-generated method stub
		return null;
	}

	public InsightMethods insights() {
		// TODO Auto-generated method stub
		return null;
	}

	public LikeMethods likes() {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkMethods links() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocationMethods locations() {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageMethods messages() {
		// TODO Auto-generated method stub
		return null;
	}

	public NoteMethods notes() {
		// TODO Auto-generated method stub
		return null;
	}

	public NotificationMethods notifications() {
		// TODO Auto-generated method stub
		return null;
	}

	public PageMethods pages() {
		// TODO Auto-generated method stub
		return null;
	}

	public PermissionMethods permissions() {
		// TODO Auto-generated method stub
		return null;
	}

	public PhotoMethods photos() {
		// TODO Auto-generated method stub
		return null;
	}

	public PokeMethods pokes() {
		// TODO Auto-generated method stub
		return null;
	}

	public PostMethods posts() {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestionMethods questions() {
		// TODO Auto-generated method stub
		return null;
	}

	public SearchMethods search() {
		// TODO Auto-generated method stub
		return null;
	}

	public SubscribeMethods subscribes() {
		// TODO Auto-generated method stub
		return null;
	}

	public TestUserMethods testUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserMethods users() {
		// TODO Auto-generated method stub
		return null;
	}

	public VideoMethods videos() {
		// TODO Auto-generated method stub
		return null;
	}

}
