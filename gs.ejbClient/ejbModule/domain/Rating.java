package domain;

public class Rating {
	private int userId;
	private int interestId;
	private int placeId;
	private int rating;
	
	public int getInterestId() {
		return interestId;
	}
	
	public void setInterestId(int interestId) {
		this.interestId = interestId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getPlaceId() {
		return placeId;
	}
	
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Rating [userId=" + userId + ", interestId=" + interestId 
				+ ", placeId=" + placeId + ", rating=" + rating + "]";
	}

}
