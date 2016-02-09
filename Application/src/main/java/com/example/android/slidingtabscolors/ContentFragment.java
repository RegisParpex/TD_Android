/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.slidingtabscolors;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Simple Fragment used to display some meaningful content for each page in the sample's
 * {@link android.support.v4.view.ViewPager}.
 */
public class ContentFragment extends Fragment {

    private static final String KEY_ANIMAL = "animal";

    /**
     * @return a new instance of {@link ContentFragment}, adding the parameters into a bundle and
     * setting them as arguments.
     */
    public static ContentFragment newInstance(CharSequence animalTextView) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(KEY_ANIMAL, animalTextView);

        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {

            TextView animalTextView = (TextView) view.findViewById(R.id.animal_textView);
            animalTextView.setText("Animal" + args.getCharSequence(KEY_ANIMAL));

            ImageView animalImageView  = (ImageView) view.findViewById(R.id.animal_image);
            if(args.equals(getResources().getString(R.string.tag_animal_dog)))
                animalImageView.setImageDrawable(getResources().getDrawable(R.drawable.dog));
            else if(args.equals(getResources().getString(R.string.tag_animal_mouse)))
                animalImageView.setImageDrawable(getResources().getDrawable(R.drawable.mouse));
            else if(args.equals(getResources().getString(R.string.tag_animal_duck)))
                animalImageView.setImageDrawable(getResources().getDrawable(R.drawable.duck));
        }
    }
}
