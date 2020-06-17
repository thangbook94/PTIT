/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apply.Iterator;

public interface ChannelCollection {

    public void addChannel(Channel c);

    public void removeChannel(Channel c);

    public ChannelIterator iterator(ChannelTypeEnum type);

}