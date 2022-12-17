package nz.theysay.shieldsandlives;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

import nz.theysay.shieldsandlives.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private int f;
    private int s;

    private int lives = 5;

    private String w;
    private boolean step = false;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (step == true) {
                    binding.textviewFirst.setText(w + " " + f + " x " + s + " =  " + f*s);

                    if(w.equals("Life ♡")) {
                        lives = lives - 1;

                        String livesText =  "Lives remaining: " + lives;
                        if (lives == 0) {
                            livesText = livesText + " ☠";
                        }
                        binding.textviewLives.setText(livesText);



                    }

                    step = false;
                    return;
                }


                Random r  = new Random();
                int first = r.nextInt(11);
                int second;
                if (first == 6 || first == 7) {
                    second = r.nextInt(11);
                } else {
                    second = r.nextInt(2) + 6;
                }

                int life = r.nextInt(2);
                String what = "Shield \uD83D\uDEE1 ";
                if (life == 0) {
                    what = "Life ♡";
                }
                f = first;
                s = second;
                w = what;
                step = true;

                binding.textviewFirst.setText(what + " " + first + " x " + second + " =  ???");

//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_Fir stFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}