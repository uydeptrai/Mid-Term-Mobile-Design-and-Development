package com.example.hoanggiauy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class AnswerAdapter extends ArrayAdapter<String> {

    private ArrayList<String> answers;
    private Context context;

    public AnswerAdapter(Context context, ArrayList<String> answers) {
        super(context, 0, answers);
        this.context = context;
        this.answers = answers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String answer = answers.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_answer, parent, false);
        }

        TextView textViewAnswer = convertView.findViewById(R.id.textView_answer);
        textViewAnswer.setText(answer);

        return convertView;
    }
}
