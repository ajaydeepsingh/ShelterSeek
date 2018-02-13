//package cs2340.cs2340shelterseek;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import java.util.Arrays;
//import java.util.List;
//
//
//
//public class User implements Parcelable {
//
//
//    private static int Next_Id = 0;
//
//    /** this students id number */
//    private int _id;
//
//    /** this students name */
//    private String _name;
//
//    private String _password;
//
//
//
//    /* **********************
//     * Getters and setters
//     */
//    public String getName() { return _name; }
//    public void setName(String name) { _name = name; }
//
//    //no setter for this.  id is a read only field
//    public int getId() { return _id; }
//
//    public String getPassword() {return _password; }
//    public void setPassword(String password) { _password = password; }
//
//
//    public User(String name, String password) {
//        _name = name;
//        _password = password;
//        _id = User.Next_Id++;
//
//    }
//
//
//    /**
//     * No param constructor -- DO NOT CALL NORMALLY
//     * This constructor only for GUI use in edit/new student dialog
//     */
//    public User() {
//        this("enter new name" , "NA");
//    }
//
//    /**
//     *
//     * @return the display string representation
//     */
//    @Override
//    public String toString() {
//        return _name + " " + _password;
//    }
//
//
//    /* *********************************
//     * These methods are required by the Parcelable interface
//     * I just wanted to demo how to pass information from one activity
//     * to another through an intent.   If this were a real project, I
//     * would probably have the facade maintain information about the
//     * currently selected student which would remove the need to
//     * pass the student object in an intent, which would remove the need
//     * to implement the Parcelable interface and these methods.
//     */
//
//    /**
//     * Constructor used by Parcel to make a new student out of the
//     * parceled information
//     *
//     * @param in  the parcel containing the student information
//     */
//    private User(Parcel in) {
//        _name = in.readString();
//        _password = in.readString();
//        _id = in.readInt();
//
//
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    /* *************************
//       If you add new instance vars to Student, you will need to add them to the write
//       Be sure the order you write information matches the order that the constructor above
//       reads them.
//     */
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//         dest.writeString(_name);
//         dest.writeString(_password);
//         dest.writeInt(_id);
//
//    }
//
//    /**
//     * Should not have to edit this method if the constructor and write method are
//     * working correctly.
//     */
//    public static final Parcelable.Creator<User> CREATOR
//            = new Parcelable.Creator<User>() {
//        public User createFromParcel(Parcel in) {
//            return new User(in);
//        }
//
//        public User[] newArray(int size) {
//            return new User[size];
//        }
//    };
//}
