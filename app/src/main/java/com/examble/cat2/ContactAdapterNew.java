package cat.cattutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.examble.cat2.R;

import java.util.ArrayList;

public class ContactAdapterNew extends RecyclerView.Adapter<ContactAdapterNew.ContactViewHolder> {


    public ContactAdapterNew(OnClickItemListner onClickItemListner) {
        this.onClickItemListner = onClickItemListner;
    }
    private final OnClickItemListner onClickItemListner;

    public ArrayList<cat.cattutorial.Contact> contacts = new ArrayList<>();
    interface OnClickItemListner{
        void c (cat.cattutorial.Contact contact, int position);
        void delete (Contact contact ,int position);

    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_new, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, final int position) {
        holder.onBind(contacts.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListner.c(contacts.get(position),position);
                onClickItemListner.delete(contacts.get(position),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvNumber;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvNumber = itemView.findViewById(R.id.tv_number);
        }

        void onBind(Contact contact) {
            tvName.setText(contact.getName());
            tvNumber.setText(contact.getNumber());
        }
    }
}
