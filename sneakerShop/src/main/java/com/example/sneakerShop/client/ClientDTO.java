package com.example.sneakerShop.client;

/**
 * The data transfer object (dto) for the Client model.
 */
public class ClientDTO {

    /**
     * the id of the client
     */
    protected Long id;

    /**
     * the lastname of the client
     */
    protected String lastName;

    /**
     * the firstname of the client
     */
    protected String firstName;

    /**
     * the email of the client
     */
    protected String email;

    /**
     * the password of the client
     */
    protected String password;

    public ClientDTO() {
        super();
    }

    /**
     * Returns a reference to the field {@link #id}.
     *
     * @return the field {@link #id}
     */
    public Long getId() {
        return id;
    }

    /**
     * Changes the field {@link #id} to param id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns a reference to the field {@link #lastName}.
     *
     * @return the field {@link #lastName}
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Changes the field {@link #lastName} to param lastname.
     *
     * @param lastName the new lastName
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a reference to the field {@link #firstName}.
     *
     * @return the field {@link #firstName}
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Changes the field {@link #firstName} to param firstName.
     *
     * @param firstName the new firstName
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns a reference to the field {@link #email}.
     *
     * @return the field {@link #email}
     */
    public String getEmail() {
        return email;
    }


    /**
     * Changes the field {@link #email} to param email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a reference to the field {@link #password}.
     *
     * @return the field {@link #password}
     */
    public String getPassword() {
        return password;
    }

    /**
     * Changes the field {@link #password} to param password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
