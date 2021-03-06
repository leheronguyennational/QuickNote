package kn.multinote.ui.activity;

import kn.multinote.defines.MessageConstant;
import kn.multinote.dto.NoteDto;
import kn.multinote.ui.adapter.NoteAdapter;
import kn.multinote.ui.controller.NoteController;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class ShownoteActivity extends Activity implements OnClickListener,
		Callback {
	private NoteAdapter noteAdapter;
	private NoteController mController;
	public ListView lvNotes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_note);
		mController = new NoteController();
		lvNotes = (ListView) findViewById(R.id.lvNote);
		mController.addOutboxHandler(new Handler(this));
		noteAdapter = new NoteAdapter(this, mController);
		lvNotes.setAdapter(noteAdapter);
	}

	@Override
	public void onResume() {
		super.onResume();
		noteAdapter.getData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean handleMessage(Message msg) {
		switch(msg.what){
		case MessageConstant.MESSAGE_VIEW_NOTE:
			Intent intent = new Intent(this,
					DisplayCaptureSoundActivity.class);
			intent.putExtra("note", (NoteDto)msg.obj);
			startActivity(intent);
			break;
		}
		return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
