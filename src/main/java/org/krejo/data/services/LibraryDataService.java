package org.krejo.data.services;

import org.krejo.data.exception.IllegalLibraryException;
import org.krejo.data.exception.LibraryBadDTOException;
import org.krejo.data.models.address.AddressEntity;
import org.krejo.data.models.book.BookDTO;
import org.krejo.data.models.book.BookResource;
import org.krejo.data.models.library.Library;
import org.krejo.data.models.library.LibraryDTO;
import org.krejo.data.models.library.LibraryEntity;
import org.krejo.data.models.library.LibraryResource;
import org.krejo.database.AddressRepo;
import org.krejo.database.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibraryDataService {
    @Autowired
    LibraryRepo libraryRepo;
    @Autowired
    AddressDataService addressDataService;
    @Autowired
    AddressRepo addressRepo;

    public List<LibraryResource> getAllLibraries() {
        List<LibraryResource> libraries = new ArrayList<>();
        for (LibraryEntity libraryEntity : libraryRepo.findAll()) {
            libraries.add(convertLibraryToLibraryResource(convertLibraryEntityToLibrary(libraryEntity)));
        }

        return libraries;
    }

    public LibraryResource getLibrary(int id) throws IllegalLibraryException {
        Optional<LibraryEntity> libraryEntity = libraryRepo.findById(id);
        if (libraryEntity.isPresent()) {
            return convertLibraryToLibraryResource(
                    convertLibraryEntityToLibrary(libraryEntity.get()));
        }

        throw new IllegalLibraryException("Library not found");
    }

    public LibraryResource addLibrary(LibraryDTO libraryDTO) throws LibraryBadDTOException {
        Library library = convertLibraryDTOToLibrary(libraryDTO);

        AddressEntity savingAddressEntity = addressRepo.save(addressDataService
                .convertAddressToAddressEntity(library.getAddress()));


        LibraryEntity libraryEntity = libraryRepo.save(convertLibraryToLibraryEntity(library, savingAddressEntity));
        libraryEntity.setAddressEntity(savingAddressEntity);


        libraryEntity.setBooks(new ArrayList<>());

        return convertLibraryToLibraryResource(convertLibraryEntityToLibrary(libraryEntity));
    }

    public LibraryResource editLibrary(int id, LibraryDTO libraryDTO) throws LibraryBadDTOException, IllegalLibraryException {
        Library library = convertLibraryDTOToLibrary(libraryDTO);
        Optional<LibraryEntity> oldLibrary = libraryRepo.findById(id);
        AddressEntity savingAddressEntity = addressRepo.save(addressDataService
                .convertAddressToAddressEntity(library.getAddress()));
        if (oldLibrary.isPresent()) {
            libraryRepo.delete(oldLibrary.get());
            LibraryEntity newLibraryEntity = libraryRepo.save(convertLibraryToLibraryEntity(library, savingAddressEntity));
            return convertLibraryToLibraryResource(convertLibraryEntityToLibrary(newLibraryEntity));
        }
        throw new IllegalLibraryException("Library with id " + id + " not found");

    }

    public LibraryResource deleteLibrary(int id) throws IllegalLibraryException {
        Library library = new Library();

        Optional<LibraryEntity> libraryEntity = libraryRepo.findById(id);
        if (libraryEntity.isPresent()){
            libraryRepo.delete(libraryEntity.get());
        } else {
            throw new IllegalLibraryException("Library with id " + id + " wasnt found");
        }

        return convertLibraryToLibraryResource(convertLibraryEntityToLibrary(libraryEntity.get()));
    }

    private LibraryEntity convertLibraryToLibraryEntity(Library library, AddressEntity addressEntity) {
        LibraryEntity libraryEntity = new LibraryEntity();

        libraryEntity.setName(library.getName());
        libraryEntity.setId(null);
        libraryEntity.setAddressEntity(addressEntity);
        libraryEntity.setBooks(new ArrayList<>());

        return libraryEntity;
    }

    private Library convertLibraryDTOToLibrary(LibraryDTO libraryDTO) throws LibraryBadDTOException {
        Library library = new Library();
        checkLibraryDTO(libraryDTO);
        library.setId(-1);
        library.setName(libraryDTO.getName());
        library.setAddress(addressDataService.
                convertAddressDTOToAddress(libraryDTO.getAddress()));

        library.setBooks(new ArrayList<>());

        return library;
    }

    private void checkLibraryDTO(LibraryDTO libraryDTO) throws LibraryBadDTOException {
        if (libraryDTO.getAddress() == null || libraryDTO.getName().isEmpty()) {
            throw new LibraryBadDTOException("Bad DTO");
        }
    }

    private LibraryResource convertLibraryToLibraryResource(Library library) {
        LibraryResource libraryResource = new LibraryResource();

        libraryResource.setId(library.getId());
        libraryResource.setName(library.getName());
        //todo moch den Converter
        libraryResource.setBooks(new ArrayList<>());
        libraryResource.setStreet(library.getAddress().getStreet());
        libraryResource.setZipCode(library.getAddress().getZipCode());
        libraryResource.setHouseNumber(library.getAddress().getHouseNumber());

        return libraryResource;
    }

    private Library convertLibraryEntityToLibrary(LibraryEntity libraryEntity) {
        Library library = new Library();

        library.setId(libraryEntity.getId());
        library.setName(libraryEntity.getName());
        library.setAddress(addressDataService.
                convertAddressEntityToAddress(libraryEntity.getAddressEntity()));
        //todo find des ausa
        library.setBooks(new ArrayList<>());

        return library;
    }


    public List<BookResource> getBooks(int id) {
        return null;
    }

    public BookResource getBook(int libraryId, int bookId) {
        return null;
    }

    public BookResource addBook(int storeId, BookDTO bookDTO) {
        return null;
    }

    public BookResource editBook(int storeId, int productId, BookDTO productDto) {
        return null;
    }

    public BookResource deleteBook(int storeId, int productId) {
        return null;
    }
}
