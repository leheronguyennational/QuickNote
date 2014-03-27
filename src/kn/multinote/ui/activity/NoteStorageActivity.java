package kn.multinote.ui.activity;

import kn.multinote.data.viewmodel.activity.NoteStorageViewModel;
import kn.multinote.ui.adapter.MainPagerAdapter;
import kn.multinote.ui.fragment.HomeScreenFragment;
import kn.multinote.ui.fragment.MainMenuFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class NoteStorageActivity extends FragmentActivity{
	
	private NoteStorageViewModel mViewModel;
	
	private ViewPager mMainPager;
	private MainPagerAdapter mMainPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_storage);
		
		prepareViewModel();
		initMainPager();
	}
	
	
	private void prepareViewModel() {
		mViewModel =  new NoteStorageViewModel();
	}
	
	private void initMainPager() {
		mMainPager = (ViewPager) findViewById(R.id.pager);
		mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mViewModel.pagerAdapter);
		
		HomeScreenFragment homeFragment = new HomeScreenFragment();
		MainMenuFragment mainMenuFragment = new MainMenuFragment();
		mViewModel.pagerAdapter.fragments.add(mainMenuFragment);
		mViewModel.pagerAdapter.fragments.add(homeFragment);
		
		mMainPager.setAdapter(mMainPagerAdapter);

	}
}
