/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.Iterator;

public class Channel {

    private double frequency;
    private ChannelTypeEnum TYPE;

    public Channel(double freq, ChannelTypeEnum type) {
        this.frequency = freq;
        this.TYPE = type;
    }

    public double getFrequency() {
        return frequency;
    }

    public ChannelTypeEnum getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "Frequency=" + this.frequency + ", Type=" + this.TYPE;
    }

}