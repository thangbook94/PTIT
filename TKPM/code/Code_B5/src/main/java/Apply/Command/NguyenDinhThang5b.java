/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apply.Command;

public class NguyenDinhThang5b {

    public static void main(String[] args) {
        SimpleRemoteControl remote
                = new SimpleRemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();
        remote.setCommand(new LightOnCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new StereoOnWithCDCommand(stereo));
        remote.buttonWasPressed();
        remote.setCommand(new StereoOffCommand(stereo));
        remote.buttonWasPressed();
    }
}
