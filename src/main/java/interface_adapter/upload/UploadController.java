package interface_adapter.upload;


import use_case.upload.*;

import java.net.URI;

public class UploadController {
    final UploadInputBoundary uploadUseCaseInteractor;

    public UploadController(UploadInputBoundary uploadUseCaseInteractor) {
        this.uploadUseCaseInteractor = uploadUseCaseInteractor;
    }
    // why do we need description as input data?
    public void execute(String title, URI filePath, String description) {
        UploadInputData uploadInputData = new UploadInputData(
                title, description, filePath);

        uploadUseCaseInteractor.execute(uploadInputData);
    }
}

