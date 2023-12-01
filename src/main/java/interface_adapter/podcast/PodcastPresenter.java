package interface_adapter.podcast;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_episode.CreateEpisodeState;
import interface_adapter.create_episode.CreateEpisodeViewModel;
import interface_adapter.home.HomeState;
import interface_adapter.home.HomeViewModel;
import use_case.podcast.PodcastOutputBoundary;
import use_case.podcast.PodcastOutputData;


public class PodcastPresenter implements PodcastOutputBoundary {

    private final PodcastViewModel podcastViewModel;
    private final CreateEpisodeViewModel createEpisodeViewModel;
    private final ViewManagerModel viewManagerModel;
    private final HomeViewModel homeViewModel;

    public PodcastPresenter(PodcastViewModel podcastViewModel, CreateEpisodeViewModel  createEpisodeViewModel, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {
        this.podcastViewModel = podcastViewModel;
        this.createEpisodeViewModel = createEpisodeViewModel;
        this.viewManagerModel = viewManagerModel;
        this.homeViewModel = homeViewModel;
    }

    @Override
    public void prepareSuccessView(PodcastOutputData podcastData) {
        PodcastState currentState = this.podcastViewModel.getState();
        CreateEpisodeState createEpisodeState = this.createEpisodeViewModel.getState();
        createEpisodeState.setCurrentPodcastId(podcastData.getPodcast().getId());
        currentState.setCurrentPodcast(podcastData.getPodcast());
        currentState.setErrorMessage("");
        this.podcastViewModel.setState(currentState);
        this.podcastViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(podcastViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {
        HomeState currentState = this.homeViewModel.getState();
        currentState.setErrorMessage(error);
        this.homeViewModel.firePropertyChanged();
    }
}
