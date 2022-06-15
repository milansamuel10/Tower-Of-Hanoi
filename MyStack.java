import java.util.ArrayList;

public class MyStack<E> implements StackInterface<E>
{
    ArrayList<E> data = new ArrayList<E>();

    @Override
    public void push(E o)
    {
        data.add(0,o);
    }

    @Override
    public E peek()
    {
        return data.get(0);
    }

    @Override
    public E pop()
    {
        return data.remove(0);
    }

    @Override
public boolean empty()
{
    return data.isEmpty();
}

@Override
public boolean contains(E o)
{
    return data.contains(o);
}



    @Override
    public int size()
    {
        return data.size();
    }

    @Override
    public E get(int x)
    {
        return data.get(x);
    }

    @Override
    public String toString()
    {
        String s = "[";

        if(data.isEmpty())
            s += "null]";
        else if(data.size() == 1)
            s += data.get(0) + "]";
        else
        {
            for(int i = 0; i < data.size(); i++)
            {
                if(i == data.size() - 1)
                    s += data.get(i) + "]";
                else
                    s += data.get(i) + ", ";
            }
        }

        return s;
    }
}