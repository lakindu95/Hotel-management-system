
public class Room {
	private int roomNum;

	private String roomName;

	private double roomRate;

	public int getRoomNum() {

		return roomNum;

	}

	public void setRoomNum(int roomNum) {

		this.roomNum = roomNum;

	}

	public void setRoomName(String roomName) {

		this.roomName = roomName;

	}

	public String getRoomName() {

		return roomName;

	}

	public double getRoomRate() {

		return roomRate;

	}

	public void setRoomRate() {

		if (getRoomNum() == 1 || getRoomNum() == 2 || getRoomNum() == 3) {

			roomRate = 500.00;

		}

		else if (getRoomNum() == 4 || getRoomNum() == 5 || getRoomNum() == 6) {

			roomRate = 700.00;

		}

		else if (getRoomNum() == 7) {

			roomRate = 1000.00;

		}

		else if (getRoomNum() == 8 || getRoomNum() == 9 || getRoomNum() == 10) {

			roomRate = 1500.00;

		}

	}

}
