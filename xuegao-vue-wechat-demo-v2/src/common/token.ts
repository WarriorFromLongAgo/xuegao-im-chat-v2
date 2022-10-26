export const TOKEN_KEY = 'token'

export const removeToken = () => {
    localStorage.removeItem(TOKEN_KEY);
}

export const setToken = (token: string) => {
    localStorage.setItem(TOKEN_KEY, token)
}

export const getToken = () => {
    const token = localStorage.getItem(TOKEN_KEY)
    if (token && token !== 'undefined') {
        return token
    } else {
        return false
    }
}
