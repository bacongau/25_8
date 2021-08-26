package com.example.a25.di.module

import com.example.a25.model.Post
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class TestModule {
    @Named("Str_test_module")
    @Provides
    open fun provideStringFromTestModule(): String? {
        return "This is a String from Test Module"
    }

    @Named("Post_Test_module")
    @Provides
    open fun providePostFromTestModule(): Post? {
        return Post("100", "100", "this is post's title", "this is post's body")
    }
}