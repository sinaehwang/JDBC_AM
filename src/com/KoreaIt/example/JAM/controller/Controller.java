package com.KoreaIt.example.JAM.controller;

import java.util.Scanner;

import com.KoreaIt.example.container.Container;

public abstract class Controller {
	protected Scanner sc;

	public Controller() {
		this.sc = Container.sc;
	}

}